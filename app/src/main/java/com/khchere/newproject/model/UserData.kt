package com.khchere.newproject.model


import com.google.gson.annotations.SerializedName

data class UserData(
        @SerializedName("acc_total_win_per") val accTotalWinPer: String,
        @SerializedName("alive_user") val aliveUser: String,
        @SerializedName("clan_mark1") val clanMark1: String,
        @SerializedName("clan_mark2") val clanMark2: String,
        @SerializedName("clan_name") val clanName: String,
        @SerializedName("clan_no") val clanNo: String,
        @SerializedName("Dataset") val dataset: List<UserImageData>,
        @SerializedName("error_msg") val errorMsg: String,
        @SerializedName("friend_ask_tag") val friendAskTag: String,
        @SerializedName("friend_tag") val friendTag: String,
        @SerializedName("is_scalar") val isScalar: String,
        @SerializedName("kill_death") val killDeath: String,
        @SerializedName("level_no") val levelNo: Int,
        @SerializedName("membership_grade") val membershipGrade: Int,
        @SerializedName("mobile_join") val mobileJoin: String,
        @SerializedName("rank_no") val rankNo: Int,
        @SerializedName("row_count") val rowCount: Int,
        @SerializedName("season_level_join_flag") val seasonLevelJoinFlag: String,
        @SerializedName("season_level_no") val seasonLevelNo: Int,
        @SerializedName("sp_rtn") val spRtn: Int,
        @SerializedName("total_user_cnt") val totalUserCnt: Int,
        @SerializedName("user_background_img") val userBackgroundImg: String,
        @SerializedName("user_img") val userImg: String,
        @SerializedName("user_intro") val userIntro: String,
        @SerializedName("user_nexon_sn") val userNexonSn: Int,
        @SerializedName("user_nick") val userNick: String,
        @SerializedName("user_sex") val userSex: String,
        @SerializedName("user_title_name") val userTitleName: String
)

data class UserImageData(
        @SerializedName("image_name") val imageName: String
)