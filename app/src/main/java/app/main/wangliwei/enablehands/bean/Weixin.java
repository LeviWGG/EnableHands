package app.main.wangliwei.enablehands.bean;


import java.util.List;

public class Weixin {
    /**
     * reason : 请求成功
     * result : {"list":[{"id":"wechat_20180203015830","title":"政协闭幕日！听听政协主席对委员们提了哪些要求？","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217143.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015830"},{"id":"wechat_20180203015829","title":"人大开幕日，31个关键词为您解读政府工作报告！","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62185771.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015829"},{"id":"wechat_20180203015828","title":"太骄傲！我在政治卷子上看到了有关峰峰的题目~","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217133.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015828"},{"id":"wechat_20180203015826","title":"男女交往最忌讳的两个字","source":"枕边音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62052958.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015826"},{"id":"wechat_20180203015865","title":"\u201c给你看个宝贝！\u201d南方姑娘打开冰箱显摆，全国网友笑岔气","source":"半岛晨报","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62214430.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015865"},{"id":"wechat_20180203015861","title":"重要通告！今年春节大连限制燃放烟花爆竹区域划定，具体时间、地点都在这儿","source":"半岛晨报","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217260.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015861"},{"id":"wechat_20180203015869","title":"陈可辛用手机拍了条广告，为什么很多人看哭了","source":"HUGO","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217285.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015869"},{"id":"wechat_20180203015893","title":"【关注】无印良品在华接受处罚整改，但日本有些人却故意要把事情\u201c搞大\u201d？！","source":"央视财经","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217364.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015893"},{"id":"wechat_20180203015915","title":"慎海雄|常怀一颗爱民之心","source":"主编温静","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-61662618.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015915"},{"id":"wechat_20180203015914","title":"2018第一个月迎来全平台整顿！","source":"主编温静","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-61662618.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015914"}],"totalPage":21933,"ps":10,"pno":1}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * list : [{"id":"wechat_20180203015830","title":"政协闭幕日！听听政协主席对委员们提了哪些要求？","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217143.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015830"},{"id":"wechat_20180203015829","title":"人大开幕日，31个关键词为您解读政府工作报告！","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62185771.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015829"},{"id":"wechat_20180203015828","title":"太骄傲！我在政治卷子上看到了有关峰峰的题目~","source":"微观峰峰","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217133.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015828"},{"id":"wechat_20180203015826","title":"男女交往最忌讳的两个字","source":"枕边音乐","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62052958.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015826"},{"id":"wechat_20180203015865","title":"\u201c给你看个宝贝！\u201d南方姑娘打开冰箱显摆，全国网友笑岔气","source":"半岛晨报","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62214430.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015865"},{"id":"wechat_20180203015861","title":"重要通告！今年春节大连限制燃放烟花爆竹区域划定，具体时间、地点都在这儿","source":"半岛晨报","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217260.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015861"},{"id":"wechat_20180203015869","title":"陈可辛用手机拍了条广告，为什么很多人看哭了","source":"HUGO","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217285.static/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015869"},{"id":"wechat_20180203015893","title":"【关注】无印良品在华接受处罚整改，但日本有些人却故意要把事情\u201c搞大\u201d？！","source":"央视财经","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217364.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015893"},{"id":"wechat_20180203015915","title":"慎海雄|常怀一颗爱民之心","source":"主编温静","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-61662618.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015915"},{"id":"wechat_20180203015914","title":"2018第一个月迎来全平台整顿！","source":"主编温静","firstImg":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-61662618.jpg/640","mark":"","url":"http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015914"}]
         * totalPage : 21933
         * ps : 10
         * pno : 1
         */

        private int totalPage;
        private int ps;
        private int pno;
        private List<ListBean> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPs() {
            return ps;
        }

        public void setPs(int ps) {
            this.ps = ps;
        }

        public int getPno() {
            return pno;
        }

        public void setPno(int pno) {
            this.pno = pno;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : wechat_20180203015830
             * title : 政协闭幕日！听听政协主席对委员们提了哪些要求？
             * source : 微观峰峰
             * firstImg : http://zxpic.gtimg.com/infonew/0/wechat_pics_-62217143.jpg/640
             * mark :
             * url : http://v.juhe.cn/weixin/redirect?wid=wechat_20180203015830
             */

            private String id;
            private String title;
            private String source;
            private String firstImg;
            private String mark;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getFirstImg() {
                return firstImg;
            }

            public void setFirstImg(String firstImg) {
                this.firstImg = firstImg;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getType() {
                return 0;
            }
        }
    }
}
