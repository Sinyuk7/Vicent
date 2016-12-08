package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

public final class Avatars {
    @SerializedName("default")
    private Default defaultX;
    @SerializedName("large")
    private Large large;
    @SerializedName("small")
    private Small small;
    @SerializedName("tiny")
    private Tiny tiny;

    public Default getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(Default defaultX) {
        this.defaultX = defaultX;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public Small getSmall() {
        return small;
    }

    public void setSmall(Small small) {
        this.small = small;
    }

    public Tiny getTiny() {
        return tiny;
    }

    public void setTiny(Tiny tiny) {
        this.tiny = tiny;
    }

    public static class Default {
        /**
         * https : https://pacdn.500px.org/777395/fcc4a2ab5f58bb2da689ed70763e23cd70eaa6a6/1.jpg?59
         */

        @SerializedName("https")
        private String https;

        public String getHttps() {
            return https;
        }

        public void setHttps(String https) {
            this.https = https;
        }
    }

    public static class Large {
        /**
         * https : https://pacdn.500px.org/777395/fcc4a2ab5f58bb2da689ed70763e23cd70eaa6a6/2.jpg?59
         */

        @SerializedName("https")
        private String https;

        public String getHttps() {
            return https;
        }

        public void setHttps(String https) {
            this.https = https;
        }
    }

    public static class Small {
        /**
         * https : https://pacdn.500px.org/777395/fcc4a2ab5f58bb2da689ed70763e23cd70eaa6a6/3.jpg?59
         */

        @SerializedName("https")
        private String https;

        public String getHttps() {
            return https;
        }

        public void setHttps(String https) {
            this.https = https;
        }
    }

    public static class Tiny {
        /**
         * https : https://pacdn.500px.org/777395/fcc4a2ab5f58bb2da689ed70763e23cd70eaa6a6/4.jpg?59
         */

        @SerializedName("https")
        private String https;

        public String getHttps() {
            return https;
        }

        public void setHttps(String https) {
            this.https = https;
        }
    }
}