package nyc.c4q.nowfeed.sports.model;

/**
 * Created by jervon.arnoldd on 12/16/17.
 */

public class Fullgameschedule {

    String lastUpdatedOn;
    GameEntry[] gameentry;

    public String getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public GameEntry[] getGameentry() {
        return gameentry;
    }

    public static class GameEntry {
        String id;
        String scheduleStatus;
        String date;
        String time;
        AwayTeam awayTeam;
        HomeTeam homeTeam;
        String location;

        public String getId() {
            return id;
        }

        public String getScheduleStatus() {
            return scheduleStatus;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }

        public AwayTeam getAwayTeam() {
            return awayTeam;
        }

        public HomeTeam getHomeTeam() {
            return homeTeam;
        }

        public String getLocation() {
            return location;
        }

        public static class AwayTeam {
            String ID;
            String City;
            String Name;
            String Abbreviation;

            public void setID(String ID) {
                this.ID = ID;
            }

            public void setCity(String city) {
                City = city;
            }

            public void setName(String name) {
                Name = name;
            }

            public void setAbbreviation(String abbreviation) {
                Abbreviation = abbreviation;
            }

            public String getID() {
                return ID;
            }

            public String getCity() {
                return City;
            }

            public String getName() {
                return Name;
            }

            public String getAbbreviation() {
                return Abbreviation;
            }
        }

        public static class HomeTeam {
            String ID;
            String City;
            String Name;
            String Abbreviation;


            public void setID(String ID) {
                this.ID = ID;
            }

            public void setCity(String city) {
                City = city;
            }

            public void setName(String name) {
                Name = name;
            }

            public void setAbbreviation(String abbreviation) {
                Abbreviation = abbreviation;
            }

            public String getID() {
                return ID;
            }

            public String getCity() {
                return City;
            }

            public String getName() {
                return Name;
            }

            public String getAbbreviation() {
                return Abbreviation;
            }
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setScheduleStatus(String scheduleStatus) {
            this.scheduleStatus = scheduleStatus;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setAwayTeam(AwayTeam awayTeam) {
            this.awayTeam = awayTeam;
        }

        public void setHomeTeam(HomeTeam homeTeam) {
            this.homeTeam = homeTeam;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}




