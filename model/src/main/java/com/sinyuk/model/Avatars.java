package com.sinyuk.model;

public final class Avatars {

    private Default defaultX;
    private Default large;
    private Default small;
    private Default tiny;

    public Default getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(Default defaultX) {
        this.defaultX = defaultX;
    }

    public Default getLarge() {
        return large;
    }

    public void setLarge(Default large) {
        this.large = large;
    }

    public Default getSmall() {
        return small;
    }

    public void setSmall(Default small) {
        this.small = small;
    }

    public Default getTiny() {
        return tiny;
    }

    public void setTiny(Default tiny) {
        this.tiny = tiny;
    }

    public static class Default {
        /**
         * https : https://pacdn.500px.org/777395/fcc4a2ab5f58bb2da689ed70763e23cd70eaa6a6/1.jpg?59
         */

        private String https;

        public String getHttps() {
            return https;
        }

        public void setHttps(String https) {
            this.https = https;
        }
    }
}