package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

public final class User {


    /**
     * id : 5984691065
     * idstr : 5984691065
     * class : 1
     * screen_name : 波杰克马男
     * name : 波杰克马男
     * province : 400
     * city : 45
     * location : 海外 沙特阿拉伯
     * description : 我不想做人了
     * url :
     * profile_image_url : http://tva2.sinaimg.cn/crop.14.0.721.721.50/006x19xfjw8f9c98h7e4jj30ku0k175i.jpg
     * cover_image_phone : http://ww4.sinaimg.cn/crop.0.0.640.640.640/006x19xfgw1f99baf2tvpj30ku0kuwev.jpg
     * profile_url : u/5984691065
     * domain :
     * weihao :
     * gender : m
     * followers_count : 2120581
     * friends_count : 51
     * pagefriends_count : 0
     * statuses_count : 1189
     * favourites_count : 1
     * created_at : Mon Jul 18 16:36:56 +0800 2016
     * following : true
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : false
     * verified_type : -1
     * remark :
     * ptype : 0
     * allow_all_comment : true
     * avatar_large : http://tva2.sinaimg.cn/crop.14.0.721.721.180/006x19xfjw8f9c98h7e4jj30ku0k175i.jpg
     * avatar_hd : http://tva2.sinaimg.cn/crop.14.0.721.721.1024/006x19xfjw8f9c98h7e4jj30ku0k175i.jpg
     * verified_reason :
     * verified_trade :
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * follow_me : false
     * online_status : 0
     * bi_followers_count : 10
     * lang : zh-cn
     * star : 0
     * mbtype : 12
     * mbrank : 3
     * block_word : 0
     * block_app : 1
     * credit_score : 80
     * user_ability : 516
     * urank : 9
     */

    @SerializedName("id")
    private long id;
    @SerializedName("idstr")
    private String idstr;
    @SerializedName("class")
    private int classX;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("name")
    private String name;
    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;
    @SerializedName("location")
    private String location;
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    @SerializedName("profile_image_url")
    private String profileImageUrl;
    @SerializedName("cover_image_phone")
    private String coverImagePhone;
    @SerializedName("profile_url")
    private String profileUrl;
    @SerializedName("domain")
    private String domain;
    @SerializedName("weihao")
    private String weihao;
    @SerializedName("gender")
    private String gender;
    @SerializedName("followers_count")
    private int followersCount;
    @SerializedName("friends_count")
    private int friendsCount;
    @SerializedName("pagefriends_count")
    private int pagefriendsCount;
    @SerializedName("statuses_count")
    private int statusesCount;
    @SerializedName("favourites_count")
    private int favouritesCount;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("following")
    private boolean following;
    @SerializedName("allow_all_act_msg")
    private boolean allowAllActMsg;
    @SerializedName("geo_enabled")
    private boolean geoEnabled;
    @SerializedName("verified")
    private boolean verified;
    @SerializedName("verified_type")
    private int verifiedType;
    @SerializedName("remark")
    private String remark;
    @SerializedName("ptype")
    private int ptype;
    @SerializedName("allow_all_comment")
    private boolean allowAllComment;
    @SerializedName("avatar_large")
    private String avatarLarge;
    @SerializedName("avatar_hd")
    private String avatarHd;
    @SerializedName("verified_reason")
    private String verifiedReason;
    @SerializedName("verified_trade")
    private String verifiedTrade;
    @SerializedName("verified_reason_url")
    private String verifiedReasonUrl;
    @SerializedName("verified_source")
    private String verifiedSource;
    @SerializedName("verified_source_url")
    private String verifiedSourceUrl;
    @SerializedName("follow_me")
    private boolean followMe;
    @SerializedName("online_status")
    private int onlineStatus;
    @SerializedName("bi_followers_count")
    private int biFollowersCount;
    @SerializedName("lang")
    private String lang;
    @SerializedName("star")
    private int star;
    @SerializedName("mbtype")
    private int mbtype;
    @SerializedName("mbrank")
    private int mbrank;
    @SerializedName("block_word")
    private int blockWord;
    @SerializedName("block_app")
    private int blockApp;
    @SerializedName("credit_score")
    private int creditScore;
    @SerializedName("user_ability")
    private int userAbility;
    @SerializedName("urank")
    private int urank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public int getClassX() {
        return classX;
    }

    public void setClassX(int classX) {
        this.classX = classX;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getCoverImagePhone() {
        return coverImagePhone;
    }

    public void setCoverImagePhone(String coverImagePhone) {
        this.coverImagePhone = coverImagePhone;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getWeihao() {
        return weihao;
    }

    public void setWeihao(String weihao) {
        this.weihao = weihao;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getPagefriendsCount() {
        return pagefriendsCount;
    }

    public void setPagefriendsCount(int pagefriendsCount) {
        this.pagefriendsCount = pagefriendsCount;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isAllowAllActMsg() {
        return allowAllActMsg;
    }

    public void setAllowAllActMsg(boolean allowAllActMsg) {
        this.allowAllActMsg = allowAllActMsg;
    }

    public boolean isGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getVerifiedType() {
        return verifiedType;
    }

    public void setVerifiedType(int verifiedType) {
        this.verifiedType = verifiedType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public boolean isAllowAllComment() {
        return allowAllComment;
    }

    public void setAllowAllComment(boolean allowAllComment) {
        this.allowAllComment = allowAllComment;
    }

    public String getAvatarLarge() {
        return avatarLarge;
    }

    public void setAvatarLarge(String avatarLarge) {
        this.avatarLarge = avatarLarge;
    }

    public String getAvatarHd() {
        return avatarHd;
    }

    public void setAvatarHd(String avatarHd) {
        this.avatarHd = avatarHd;
    }

    public String getVerifiedReason() {
        return verifiedReason;
    }

    public void setVerifiedReason(String verifiedReason) {
        this.verifiedReason = verifiedReason;
    }

    public String getVerifiedTrade() {
        return verifiedTrade;
    }

    public void setVerifiedTrade(String verifiedTrade) {
        this.verifiedTrade = verifiedTrade;
    }

    public String getVerifiedReasonUrl() {
        return verifiedReasonUrl;
    }

    public void setVerifiedReasonUrl(String verifiedReasonUrl) {
        this.verifiedReasonUrl = verifiedReasonUrl;
    }

    public String getVerifiedSource() {
        return verifiedSource;
    }

    public void setVerifiedSource(String verifiedSource) {
        this.verifiedSource = verifiedSource;
    }

    public String getVerifiedSourceUrl() {
        return verifiedSourceUrl;
    }

    public void setVerifiedSourceUrl(String verifiedSourceUrl) {
        this.verifiedSourceUrl = verifiedSourceUrl;
    }

    public boolean isFollowMe() {
        return followMe;
    }

    public void setFollowMe(boolean followMe) {
        this.followMe = followMe;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getBiFollowersCount() {
        return biFollowersCount;
    }

    public void setBiFollowersCount(int biFollowersCount) {
        this.biFollowersCount = biFollowersCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getMbtype() {
        return mbtype;
    }

    public void setMbtype(int mbtype) {
        this.mbtype = mbtype;
    }

    public int getMbrank() {
        return mbrank;
    }

    public void setMbrank(int mbrank) {
        this.mbrank = mbrank;
    }

    public int getBlockWord() {
        return blockWord;
    }

    public void setBlockWord(int blockWord) {
        this.blockWord = blockWord;
    }

    public int getBlockApp() {
        return blockApp;
    }

    public void setBlockApp(int blockApp) {
        this.blockApp = blockApp;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public int getUserAbility() {
        return userAbility;
    }

    public void setUserAbility(int userAbility) {
        this.userAbility = userAbility;
    }

    public int getUrank() {
        return urank;
    }

    public void setUrank(int urank) {
        this.urank = urank;
    }
}