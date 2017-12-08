package com.vip.movie.fuli.Bean;

import java.util.List;

/**
 * Created by 闫鑫 on 2017/12/7.
 */

public class Women {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"【美D共享】◆ 夜景旗袍","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/29/10/201511291058402931-2089977.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6887487-0-1.html"},{"ctime":"2016-03-06 14:11","title":"美腿秀292（2015.11.29）","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/29/20/20151129201529931-2285289.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6887701-0-1.html"},{"ctime":"2016-03-06 14:11","title":"☆成熟女人\u2026\u2026[风韵迷人 赵芸 53p]\u2026\u2026第工百六十八辑","description":"华声美女","picUrl":"http://image.hnol.net/c/2015-11/29/20/201511292055513121-1559530.jpg","url":"http://bbs.voc.com.cn/mm/meinv-6887726-0-1.html"},{"ctime":"2016-03-06 14:11","title":"丰满大尺度的妙龄日本少女居家靓照","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-151130103106122.jpg","url":"http://www.du114.com/a/siwameinv/50252.html"},{"ctime":"2016-03-06 14:11","title":"丰满美臀日本少女情趣内衣性感写真","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-15113010021XJ.jpg","url":"http://www.du114.com/a/siwameinv/50285.html"},{"ctime":"2016-03-06 14:11","title":"办公室知性秘书性感魅惑艳照","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-1511301001502V.jpg","url":"http://www.du114.com/a/siwameinv/50282.html"},{"ctime":"2016-03-06 14:11","title":"性感高挑御姐私房艳照","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-15113010011H11.jpg","url":"http://www.du114.com/a/siwameinv/50278.html"},{"ctime":"2016-03-06 14:11","title":"冷艳性感腿模丝袜美腿写真","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-151130100259394.jpg","url":"http://www.du114.com/a/siwameinv/50277.html"},{"ctime":"2016-03-06 14:11","title":"性感日本美少女情趣内衣写真","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-151130100322A7.jpg","url":"http://www.du114.com/a/siwameinv/50275.html"},{"ctime":"2016-03-06 14:11","title":"嫩模顾欣怡捆绑性感特写","description":"114美女","picUrl":"http://t1.du114.com/uploads/151130/10-151130100356113.jpg","url":"http://www.du114.com/a/siwameinv/50271.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-03-06 14:11
         * title : 【美D共享】◆ 夜景旗袍
         * description : 华声美女
         * picUrl : http://image.hnol.net/c/2015-11/29/10/201511291058402931-2089977.jpg
         * url : http://bbs.voc.com.cn/mm/meinv-6887487-0-1.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
