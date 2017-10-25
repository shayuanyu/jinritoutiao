package com.example.lenovo.jinritoutiao.bean;

import java.util.List;

/**
 * Created by Lenovo on 2017/9/8.
 */

public class Newsbean {

    /**
     * message : success
     * data : {"max_cursor":0,"login_status":0,"has_more":false,"change_list":[],"tips":{"display_info":"暂无更新，登录后内容更精彩>","open_url":"sslocal://login","web_url":"","ad_id":1089,"app_name":"今日头条","package_name":"","type":"app","display_duration":4,"download_url":"","id":1089},"min_cursor":0,"data":[{"comment_visible_count":3,"device_type":0,"forward_num":0,"comment_id":0,"digg_limit":0,"talk_type":0,"source_type":1,"reason":"","create_time":1504871708,"is_admin":0,"user":{"verified_reason":"","is_blocking":0,"avatar_url":"http://p1.pstatp.com/thumb/3157/5837337619","user_id":3612927328,"screen_name":"今日头条","is_friend":0,"is_blocked":0,"user_verified":false,"description":"今日头条官方媒体帐号"},"large_image_list":[],"device_model":"","user_digg":0,"origin_item":{},"id":19999999999,"digg_list":[],"content":"您好，动态服务将于7月31日全面升级为「关注频道」，届时请在手机里安装的应用市场升级至今日头条APP最新版，即可在新版APP首屏导航栏最左侧看到，欢迎体验！（备注：旧版动态功能将于7月27日暂停服务）","cell_type":1,"group":{},"talk_item":{},"image_type":{},"share_url":"http://www.toutiao.com/","digg_count":0,"comments":[],"cursor":1504871708788,"item_type":110,"comment_count":0,"flags":2,"modify_time":1504871708,"is_pgc_author":0,"delete":0,"type":1,"thumb_image_list":[],"action_desc":""}]}
     */

    private String message;
    private DataBeanX data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * max_cursor : 0
         * login_status : 0
         * has_more : false
         * change_list : []
         * tips : {"display_info":"暂无更新，登录后内容更精彩>","open_url":"sslocal://login","web_url":"","ad_id":1089,"app_name":"今日头条","package_name":"","type":"app","display_duration":4,"download_url":"","id":1089}
         * min_cursor : 0
         * data : [{"comment_visible_count":3,"device_type":0,"forward_num":0,"comment_id":0,"digg_limit":0,"talk_type":0,"source_type":1,"reason":"","create_time":1504871708,"is_admin":0,"user":{"verified_reason":"","is_blocking":0,"avatar_url":"http://p1.pstatp.com/thumb/3157/5837337619","user_id":3612927328,"screen_name":"今日头条","is_friend":0,"is_blocked":0,"user_verified":false,"description":"今日头条官方媒体帐号"},"large_image_list":[],"device_model":"","user_digg":0,"origin_item":{},"id":19999999999,"digg_list":[],"content":"您好，动态服务将于7月31日全面升级为「关注频道」，届时请在手机里安装的应用市场升级至今日头条APP最新版，即可在新版APP首屏导航栏最左侧看到，欢迎体验！（备注：旧版动态功能将于7月27日暂停服务）","cell_type":1,"group":{},"talk_item":{},"image_type":{},"share_url":"http://www.toutiao.com/","digg_count":0,"comments":[],"cursor":1504871708788,"item_type":110,"comment_count":0,"flags":2,"modify_time":1504871708,"is_pgc_author":0,"delete":0,"type":1,"thumb_image_list":[],"action_desc":""}]
         */

        private int max_cursor;
        private int login_status;
        private boolean has_more;
        private TipsBean tips;
        private int min_cursor;
        private List<?> change_list;
        private List<DataBean> data;

        public int getMax_cursor() {
            return max_cursor;
        }

        public void setMax_cursor(int max_cursor) {
            this.max_cursor = max_cursor;
        }

        public int getLogin_status() {
            return login_status;
        }

        public void setLogin_status(int login_status) {
            this.login_status = login_status;
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public TipsBean getTips() {
            return tips;
        }

        public void setTips(TipsBean tips) {
            this.tips = tips;
        }

        public int getMin_cursor() {
            return min_cursor;
        }

        public void setMin_cursor(int min_cursor) {
            this.min_cursor = min_cursor;
        }

        public List<?> getChange_list() {
            return change_list;
        }

        public void setChange_list(List<?> change_list) {
            this.change_list = change_list;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class TipsBean {
            /**
             * display_info : 暂无更新，登录后内容更精彩>
             * open_url : sslocal://login
             * web_url :
             * ad_id : 1089
             * app_name : 今日头条
             * package_name :
             * type : app
             * display_duration : 4
             * download_url :
             * id : 1089
             */

            private String display_info;
            private String open_url;
            private String web_url;
            private int ad_id;
            private String app_name;
            private String package_name;
            private String type;
            private int display_duration;
            private String download_url;
            private int id;

            public String getDisplay_info() {
                return display_info;
            }

            public void setDisplay_info(String display_info) {
                this.display_info = display_info;
            }

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public int getAd_id() {
                return ad_id;
            }

            public void setAd_id(int ad_id) {
                this.ad_id = ad_id;
            }

            public String getApp_name() {
                return app_name;
            }

            public void setApp_name(String app_name) {
                this.app_name = app_name;
            }

            public String getPackage_name() {
                return package_name;
            }

            public void setPackage_name(String package_name) {
                this.package_name = package_name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getDisplay_duration() {
                return display_duration;
            }

            public void setDisplay_duration(int display_duration) {
                this.display_duration = display_duration;
            }

            public String getDownload_url() {
                return download_url;
            }

            public void setDownload_url(String download_url) {
                this.download_url = download_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        public static class DataBean {
            /**
             * comment_visible_count : 3
             * device_type : 0
             * forward_num : 0
             * comment_id : 0
             * digg_limit : 0
             * talk_type : 0
             * source_type : 1
             * reason :
             * create_time : 1504871708
             * is_admin : 0
             * user : {"verified_reason":"","is_blocking":0,"avatar_url":"http://p1.pstatp.com/thumb/3157/5837337619","user_id":3612927328,"screen_name":"今日头条","is_friend":0,"is_blocked":0,"user_verified":false,"description":"今日头条官方媒体帐号"}
             * large_image_list : []
             * device_model :
             * user_digg : 0
             * origin_item : {}
             * id : 19999999999
             * digg_list : []
             * content : 您好，动态服务将于7月31日全面升级为「关注频道」，届时请在手机里安装的应用市场升级至今日头条APP最新版，即可在新版APP首屏导航栏最左侧看到，欢迎体验！（备注：旧版动态功能将于7月27日暂停服务）
             * cell_type : 1
             * group : {}
             * talk_item : {}
             * image_type : {}
             * share_url : http://www.toutiao.com/
             * digg_count : 0
             * comments : []
             * cursor : 1504871708788
             * item_type : 110
             * comment_count : 0
             * flags : 2
             * modify_time : 1504871708
             * is_pgc_author : 0
             * delete : 0
             * type : 1
             * thumb_image_list : []
             * action_desc :
             */

            private int comment_visible_count;
            private int device_type;
            private int forward_num;
            private int comment_id;
            private int digg_limit;
            private int talk_type;
            private int source_type;
            private String reason;
            private int create_time;
            private int is_admin;
            private UserBean user;
            private String device_model;
            private int user_digg;
            private OriginItemBean origin_item;
            private long id;
            private String content;
            private int cell_type;
            private GroupBean group;
            private TalkItemBean talk_item;
            private ImageTypeBean image_type;
            private String share_url;
            private int digg_count;
            private long cursor;
            private int item_type;
            private int comment_count;
            private int flags;
            private int modify_time;
            private int is_pgc_author;
            private int delete;
            private int type;
            private String action_desc;
            private List<?> large_image_list;
            private List<?> digg_list;
            private List<?> comments;
            private List<?> thumb_image_list;

            public int getComment_visible_count() {
                return comment_visible_count;
            }

            public void setComment_visible_count(int comment_visible_count) {
                this.comment_visible_count = comment_visible_count;
            }

            public int getDevice_type() {
                return device_type;
            }

            public void setDevice_type(int device_type) {
                this.device_type = device_type;
            }

            public int getForward_num() {
                return forward_num;
            }

            public void setForward_num(int forward_num) {
                this.forward_num = forward_num;
            }

            public int getComment_id() {
                return comment_id;
            }

            public void setComment_id(int comment_id) {
                this.comment_id = comment_id;
            }

            public int getDigg_limit() {
                return digg_limit;
            }

            public void setDigg_limit(int digg_limit) {
                this.digg_limit = digg_limit;
            }

            public int getTalk_type() {
                return talk_type;
            }

            public void setTalk_type(int talk_type) {
                this.talk_type = talk_type;
            }

            public int getSource_type() {
                return source_type;
            }

            public void setSource_type(int source_type) {
                this.source_type = source_type;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getIs_admin() {
                return is_admin;
            }

            public void setIs_admin(int is_admin) {
                this.is_admin = is_admin;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public String getDevice_model() {
                return device_model;
            }

            public void setDevice_model(String device_model) {
                this.device_model = device_model;
            }

            public int getUser_digg() {
                return user_digg;
            }

            public void setUser_digg(int user_digg) {
                this.user_digg = user_digg;
            }

            public OriginItemBean getOrigin_item() {
                return origin_item;
            }

            public void setOrigin_item(OriginItemBean origin_item) {
                this.origin_item = origin_item;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCell_type() {
                return cell_type;
            }

            public void setCell_type(int cell_type) {
                this.cell_type = cell_type;
            }

            public GroupBean getGroup() {
                return group;
            }

            public void setGroup(GroupBean group) {
                this.group = group;
            }

            public TalkItemBean getTalk_item() {
                return talk_item;
            }

            public void setTalk_item(TalkItemBean talk_item) {
                this.talk_item = talk_item;
            }

            public ImageTypeBean getImage_type() {
                return image_type;
            }

            public void setImage_type(ImageTypeBean image_type) {
                this.image_type = image_type;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public long getCursor() {
                return cursor;
            }

            public void setCursor(long cursor) {
                this.cursor = cursor;
            }

            public int getItem_type() {
                return item_type;
            }

            public void setItem_type(int item_type) {
                this.item_type = item_type;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public int getModify_time() {
                return modify_time;
            }

            public void setModify_time(int modify_time) {
                this.modify_time = modify_time;
            }

            public int getIs_pgc_author() {
                return is_pgc_author;
            }

            public void setIs_pgc_author(int is_pgc_author) {
                this.is_pgc_author = is_pgc_author;
            }

            public int getDelete() {
                return delete;
            }

            public void setDelete(int delete) {
                this.delete = delete;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getAction_desc() {
                return action_desc;
            }

            public void setAction_desc(String action_desc) {
                this.action_desc = action_desc;
            }

            public List<?> getLarge_image_list() {
                return large_image_list;
            }

            public void setLarge_image_list(List<?> large_image_list) {
                this.large_image_list = large_image_list;
            }

            public List<?> getDigg_list() {
                return digg_list;
            }

            public void setDigg_list(List<?> digg_list) {
                this.digg_list = digg_list;
            }

            public List<?> getComments() {
                return comments;
            }

            public void setComments(List<?> comments) {
                this.comments = comments;
            }

            public List<?> getThumb_image_list() {
                return thumb_image_list;
            }

            public void setThumb_image_list(List<?> thumb_image_list) {
                this.thumb_image_list = thumb_image_list;
            }

            public static class UserBean {
            }

            public static class OriginItemBean {
            }

            public static class GroupBean {
            }

            public static class TalkItemBean {
            }

            public static class ImageTypeBean {
            }
        }
    }
}
