import java.util.*;

class Twitch {

    public static void main(String[] args) {
        String[] streamerInformation = new String[] { "Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant" };
        String[] commands = new String[] { "TopStreamer" };
        commands = new String[] { "StreamerOnline", "AOC", "75000", "Just Chatting", "ViewsInCategory",
                "Just Chatting" };
        commands = new String[] { "StreamerOnline", "Tfue", "110000", "Fortnite", "ViewsInCategory", "Fortnite",
                "TopStreamerInCategory", "Fortnite" };
        commands = new String[] { "UpdateCategory", "Ninja", "Fortnite", "Warzone", "ViewsInCategory", "Fortnite",
                "ViewsInCategory",
                "Warzone" };
        commands = new String[] { "StreamerOffline", "Ninja", "Fortnite", "ViewsInCategory", "Fortnite",
                "TopStreamer" };
        String[] res = solution(streamerInformation, commands);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static Map<String, String[]> streamers;

    public static String[] solution(String[] streamerInformation, String[] commands) {
        // key is Streamer, array[0] = views; array[1] = category
        streamers = new HashMap<>();
        Map<String, String[]> streamers1 = streamers;

        int i = 0;
        while (i < streamerInformation.length) {
            streamerOnline(streamerInformation[i++], streamerInformation[i++], streamerInformation[i++]);
        }

        i = 0;
        ArrayList<String> resAL = new ArrayList<>();
        while (i < commands.length) {
            String command = commands[i++];
            if (command.equals("StreamerOnline")) {
                streamerOnline(commands[i++], commands[i++], commands[i++]);
            } else if (command.equals("UpdateViews")) {
                updateViews(commands[i++], commands[i++], commands[i++]);
            } else if (command.equals("UpdateCategory")) {
                updateCategory(commands[i++], commands[i++], commands[i++]);
            } else if (command.equals("StreamerOffline")) {
                streamerOffline(commands[i++], commands[i++]);
            } else if (command.equals("ViewsInCategory")) {
                resAL.add(viewsInCategory(commands[i++]));
            } else if (command.equals("TopStreamerInCategory")) {
                String streamer = topStreamerInCategory(commands[i++]);
                if (streamer != null) {
                    resAL.add(streamer);
                }
            } else if (command.equals("TopStreamer")) {
                String streamer = topStreamer();
                if (streamer != null) {
                    resAL.add(streamer);
                }
            }
        }

        String[] res = new String[resAL.size()];
        for (i = 0; i < resAL.size(); i++) {
            res[i] = resAL.get(i);
        }

        return res;

    }

    private static void streamerOnline(String streamer, String views, String category) {
        if (!streamers.containsKey(streamer)) {
            streamers.put(streamer, new String[2]);
        }
        String[] viewsAndCategory = streamers.get(streamer);
        viewsAndCategory[0] = views;
        viewsAndCategory[1] = category;
    }

    private static void updateViews(String streamer, String views, String category) {
        if (streamers.containsKey(streamer)) {
            String[] viewsAndCategory = streamers.get(streamer);
            if (category.equals(viewsAndCategory[1])) {
                viewsAndCategory[0] = views;
            }
        }
    }

    private static void updateCategory(String streamer, String category, String newCategory) {
        if (streamers.containsKey(streamer)) {
            String[] viewsAndCategory = streamers.get(streamer);
            if (category.equals(viewsAndCategory[1])) {
                viewsAndCategory[1] = newCategory;
            }
        }
    }

    private static void streamerOffline(String streamer, String category) {
        if (streamers.containsKey(streamer)) {
            String[] viewsAndCategory = streamers.get(streamer);
            if (category.equals(viewsAndCategory[1])) {
                streamers.remove(streamer);
            }
        }

    }

    private static String viewsInCategory(String category) {
        int views = 0;
        for (Map.Entry<String, String[]> entry : streamers.entrySet()) {
            String[] viewsAndCategory = entry.getValue();
            if (category.equals(viewsAndCategory[1])) {
                views += Integer.parseInt(viewsAndCategory[0]);
            }
        }
        return String.valueOf(views);
    }

    private static String topStreamerInCategory(String category) {
        int views = 0;
        String streamer = null;
        for (Map.Entry<String, String[]> entry : streamers.entrySet()) {
            String[] viewsAndCategory = entry.getValue();
            if (category.equals(viewsAndCategory[1])) {
                if (views < Integer.parseInt(viewsAndCategory[0])) {
                    streamer = entry.getKey();
                    views = Integer.parseInt(viewsAndCategory[0]);
                }
            }
        }
        return streamer;
    }

    private static String topStreamer() {
        int views = 0;
        String streamer = null;
        for (Map.Entry<String, String[]> entry : streamers.entrySet()) {
            String[] viewsAndCategory = entry.getValue();
            if (views < Integer.parseInt(viewsAndCategory[0])) {
                streamer = entry.getKey();
                views = Integer.parseInt(viewsAndCategory[0]);
            }
        }
        return streamer;
    }
}
