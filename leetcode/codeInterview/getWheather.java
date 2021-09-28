class getWeather {

    public static void main(String[] args) {
        int num = 91;
        System.out.println(getWeather(num));
    }

    public static String getWeather(int temp) {
        String weather;
        if (temp >= 90) { 
            weather = "boiling";  // 90 is about 32 C
        }
        if (temp < 90 && temp >= 80) { 
            weather = "hot"; // 80 is about 27 C
        }
        if (temp < 80 && temp >= 70) { 
            weather = "just right"; }// 70 is about 21 C
        if (temp < 70 && temp >= 60) { 
            weather = "cool";
        }
        else {
            weather = "cold"; 
        }
        return weather; 
    }
}