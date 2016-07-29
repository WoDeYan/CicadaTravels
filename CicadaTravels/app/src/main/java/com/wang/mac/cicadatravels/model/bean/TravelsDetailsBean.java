package com.wang.mac.cicadatravels.model.bean;

import java.util.List;

/**
 * Created by mac on 16/7/26.
 * 游记详情界面总数据
 * @author wangweijian
 */
public class TravelsDetailsBean {

    /**
     * id : 294869
     * name : 我在巴黎不停地吃
     * photos_count : 99
     * start_date : 2015-05-31
     * end_date : 2015-06-04
     * level : 4
     * privacy : false
     * front_cover_photo_id : 9824518
     * views_count : 7043
     * comments_count : 50
     * likes_count : 238
     * favorites_count : 135
     * state : publish
     * source : web
     * serial_id : null
     * serial_position : null
     * serial_next_id : 0
     * updated_at : 1469444805
     * tip : {"id":16081,"texts":["巴黎地铁来得很勤快, 所以如果没有急事真的不用赶, 否则还挺危险, 毕竟站台和车身之间的间隙特别大.","要担心一下人身安全, 尤其是妹子. 第一天我下飞机乘RER B的时候有俩阿人看起来很可疑, 于是我很快移到人多的座位去了, 他俩相视一下便下车了. 防不胜防."]}
     */

    private int id;
    private String name;
    private int photos_count;
    private String start_date;
    private String end_date;
    private int level;
    private boolean privacy;
    private int front_cover_photo_id;
    private int views_count;
    private int comments_count;
    private int likes_count;
    private int favorites_count;
    private String state;
    private String source;
    private Object serial_id;
    private Object serial_position;
    private int serial_next_id;
    private int updated_at;
    /**
     * id : 16081
     * texts : ["巴黎地铁来得很勤快, 所以如果没有急事真的不用赶, 否则还挺危险, 毕竟站台和车身之间的间隙特别大.","要担心一下人身安全, 尤其是妹子. 第一天我下飞机乘RER B的时候有俩阿人看起来很可疑, 于是我很快移到人多的座位去了, 他俩相视一下便下车了. 防不胜防."]
     */

    private TipBean tip;
    /**
     * id : 123
     * name : ryota
     * image : https://img3.doubanio.com/icon/ul7009352-16.jpg
     */

    private UserBean user;
    private Object upload_token;
    private boolean current_user_favorite;
    private Object password;
    private String front_cover_photo_url;
    /**
     * id : 836854
     * trip_date : 2015-05-31
     * day : 1
     * updated_at : 1434571605
     * destination : {"id":188,"name_zh_cn":"巴黎"}
     * nodes : [{"id":1898638,"row_order":0,"score":0,"comment":null,"tips":null,"memo":{},"entry_id":null,"lat":0,"lng":0,"entry_type":null,"user_entry":false,"entry_name":null,"attraction_type":null,"updated_at":1434483259,"notes":[{"id":10651906,"row_order":-4194303,"layout":"full","col":0,
     */

    private List<TripDaysBean> trip_days;
    /**
     * id : 10650777
     * comments_count : 0
     * likes_count : 2
     * current_user_like : false
     * current_user_comment : false
     */

    private List<NotesLikesCommentsBean> notes_likes_comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public int getFront_cover_photo_id() {
        return front_cover_photo_id;
    }

    public void setFront_cover_photo_id(int front_cover_photo_id) {
        this.front_cover_photo_id = front_cover_photo_id;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Object getSerial_id() {
        return serial_id;
    }

    public void setSerial_id(Object serial_id) {
        this.serial_id = serial_id;
    }

    public Object getSerial_position() {
        return serial_position;
    }

    public void setSerial_position(Object serial_position) {
        this.serial_position = serial_position;
    }

    public int getSerial_next_id() {
        return serial_next_id;
    }

    public void setSerial_next_id(int serial_next_id) {
        this.serial_next_id = serial_next_id;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public TipBean getTip() {
        return tip;
    }

    public void setTip(TipBean tip) {
        this.tip = tip;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Object getUpload_token() {
        return upload_token;
    }

    public void setUpload_token(Object upload_token) {
        this.upload_token = upload_token;
    }

    public boolean isCurrent_user_favorite() {
        return current_user_favorite;
    }

    public void setCurrent_user_favorite(boolean current_user_favorite) {
        this.current_user_favorite = current_user_favorite;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getFront_cover_photo_url() {
        return front_cover_photo_url;
    }

    public void setFront_cover_photo_url(String front_cover_photo_url) {
        this.front_cover_photo_url = front_cover_photo_url;
    }

    public List<TripDaysBean> getTrip_days() {
        return trip_days;
    }

    public void setTrip_days(List<TripDaysBean> trip_days) {
        this.trip_days = trip_days;
    }

    public List<NotesLikesCommentsBean> getNotes_likes_comments() {
        return notes_likes_comments;
    }

    public void setNotes_likes_comments(List<NotesLikesCommentsBean> notes_likes_comments) {
        this.notes_likes_comments = notes_likes_comments;
    }

    public static class TipBean {
        private int id;
        private List<String> texts;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getTexts() {
            return texts;
        }

        public void setTexts(List<String> texts) {
            this.texts = texts;
        }
    }

    public static class UserBean {
        private int id;
        private String name;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class TripDaysBean {
        private int id;
        private String trip_date;
        private String day;
        private int updated_at;
        /**
         * id : 188
         * name_zh_cn : 巴黎
         */

        private DestinationBean destination;
        /**
         * id : 1898638
         * row_order : 0
         * score : 0
         * comment : null
         * tips : null
         * memo : {}
         * entry_id : null
         * lat : 0
         * lng : 0
         * entry_type : null
         * user_entry : false
         * entry_name : null
         * attraction_type : null
         * updated_at : 1434483259
         * notes : [{"id":10651906,"row_order":-4194303,"layout":"full","col":0,"description":"时隔六年去巴黎, 行程只有吃吃吃, 比京都那次目标还要明确23333 这次是全程一个人到当地和朋友们见面, 初尝试Airbnb, 第一次一个人旅游, 第一次找路人给我拍照. 这次行程几乎不包含景点, 也没有固定路线, 属于很散漫的旅行【每次都这样其实w","updated_at":1434477452}]
         */

        private List<NodesBean> nodes;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTrip_date() {
            return trip_date;
        }

        public void setTrip_date(String trip_date) {
            this.trip_date = trip_date;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public DestinationBean getDestination() {
            return destination;
        }

        public void setDestination(DestinationBean destination) {
            this.destination = destination;
        }

        public List<NodesBean> getNodes() {
            return nodes;
        }

        public void setNodes(List<NodesBean> nodes) {
            this.nodes = nodes;
        }

        public static class DestinationBean {
            private int id;
            private String name_zh_cn;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName_zh_cn() {
                return name_zh_cn;
            }

            public void setName_zh_cn(String name_zh_cn) {
                this.name_zh_cn = name_zh_cn;
            }
        }

        public static class NodesBean {
            private int id;
            private int row_order;
            private int score;
            private Object comment;
            private Object tips;
            private Object entry_id;
            private int lat;
            private int lng;
            private Object entry_type;
            private boolean user_entry;
            private Object entry_name;
            private Object attraction_type;
            private int updated_at;
            /**
             * id : 10651906
             * row_order : -4194303
             * layout : full
             * col : 0
             * description : 时隔六年去巴黎, 行程只有吃吃吃, 比京都那次目标还要明确23333 这次是全程一个人到当地和朋友们见面, 初尝试Airbnb, 第一次一个人旅游, 第一次找路人给我拍照. 这次行程几乎不包含景点, 也没有固定路线, 属于很散漫的旅行【每次都这样其实w
             * updated_at : 1434477452
             */

            private List<NotesBean> notes;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getRow_order() {
                return row_order;
            }

            public void setRow_order(int row_order) {
                this.row_order = row_order;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public Object getComment() {
                return comment;
            }

            public void setComment(Object comment) {
                this.comment = comment;
            }

            public Object getTips() {
                return tips;
            }

            public void setTips(Object tips) {
                this.tips = tips;
            }

            public Object getEntry_id() {
                return entry_id;
            }

            public void setEntry_id(Object entry_id) {
                this.entry_id = entry_id;
            }

            public int getLat() {
                return lat;
            }

            public void setLat(int lat) {
                this.lat = lat;
            }

            public int getLng() {
                return lng;
            }

            public void setLng(int lng) {
                this.lng = lng;
            }

            public Object getEntry_type() {
                return entry_type;
            }

            public void setEntry_type(Object entry_type) {
                this.entry_type = entry_type;
            }

            public boolean isUser_entry() {
                return user_entry;
            }

            public void setUser_entry(boolean user_entry) {
                this.user_entry = user_entry;
            }

            public Object getEntry_name() {
                return entry_name;
            }

            public void setEntry_name(Object entry_name) {
                this.entry_name = entry_name;
            }

            public Object getAttraction_type() {
                return attraction_type;
            }

            public void setAttraction_type(Object attraction_type) {
                this.attraction_type = attraction_type;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public List<NotesBean> getNotes() {
                return notes;
            }

            public void setNotes(List<NotesBean> notes) {
                this.notes = notes;
            }

            public static class NotesBean {
                private int id;
                private int row_order;
                private String layout;
                private int col;
                private String description;
                private int updated_at;
                private String photo;

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getRow_order() {
                    return row_order;
                }

                public void setRow_order(int row_order) {
                    this.row_order = row_order;
                }

                public String getLayout() {
                    return layout;
                }

                public void setLayout(String layout) {
                    this.layout = layout;
                }

                public int getCol() {
                    return col;
                }

                public void setCol(int col) {
                    this.col = col;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(int updated_at) {
                    this.updated_at = updated_at;
                }

                public static class PhotoBean{
                    private int id;
                    private int image_width;
                    private int image_height;
                    private int image_file_size;
                    private Object exif_lat;
                    private Object exif_lng;
                    private int exif_date_time_original;
                    private String url;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getImage_width() {
                        return image_width;
                    }

                    public void setImage_width(int image_width) {
                        this.image_width = image_width;
                    }

                    public int getImage_height() {
                        return image_height;
                    }

                    public void setImage_height(int image_height) {
                        this.image_height = image_height;
                    }

                    public int getImage_file_size() {
                        return image_file_size;
                    }

                    public void setImage_file_size(int image_file_size) {
                        this.image_file_size = image_file_size;
                    }

                    public Object getExif_lat() {
                        return exif_lat;
                    }

                    public void setExif_lat(Object exif_lat) {
                        this.exif_lat = exif_lat;
                    }

                    public Object getExif_lng() {
                        return exif_lng;
                    }

                    public void setExif_lng(Object exif_lng) {
                        this.exif_lng = exif_lng;
                    }

                    public int getExif_date_time_original() {
                        return exif_date_time_original;
                    }

                    public void setExif_date_time_original(int exif_date_time_original) {
                        this.exif_date_time_original = exif_date_time_original;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }
        }
    }

    public static class NotesLikesCommentsBean {
        private int id;
        private String comments_count;
        private String likes_count;
        private boolean current_user_like;
        private boolean current_user_comment;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getComments_count() {
            return comments_count;
        }

        public void setComments_count(String comments_count) {
            this.comments_count = comments_count;
        }

        public String getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(String likes_count) {
            this.likes_count = likes_count;
        }

        public boolean isCurrent_user_like() {
            return current_user_like;
        }

        public void setCurrent_user_like(boolean current_user_like) {
            this.current_user_like = current_user_like;
        }

        public boolean isCurrent_user_comment() {
            return current_user_comment;
        }

        public void setCurrent_user_comment(boolean current_user_comment) {
            this.current_user_comment = current_user_comment;
        }
    }

}
