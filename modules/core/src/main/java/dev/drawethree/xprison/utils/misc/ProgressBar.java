package dev.drawethree.xprison.utils.misc;

import dev.drawethree.xprison.utils.text.TextUtils;
import org.bukkit.ChatColor;

public class ProgressBar {

    static final ChatColor AVAILABLE_COLOR = ChatColor.GREEN;
    static final ChatColor NOT_AVAILABLE_COLOR = ChatColor.RED;
    static final String DEFAULT_DELIMITER = ":";
    static final int MAX_DELIMITERS = 30;

    public static String getProgressBar(int amountOfDelimeters, String delimeter, double current, double required) {

        if (delimeter == null || delimeter.isEmpty()) {
            delimeter = DEFAULT_DELIMITER;
        }

        amountOfDelimeters = Math.min(amountOfDelimeters, MAX_DELIMITERS);

        if (current > required) {
            current = required;
        }

        double treshold = required / amountOfDelimeters;
        int numberOfGreens = (int) (current / treshold);

        String result = AVAILABLE_COLOR +
                delimeter.repeat(Math.max(0, numberOfGreens)) +
                NOT_AVAILABLE_COLOR +
                delimeter.repeat(Math.max(0, amountOfDelimeters - numberOfGreens));

        String progressBar = TextUtils.applyColor(result);
        if (progressBar.length() > 256) {
            progressBar = progressBar.substring(0, 256);
        }

        return progressBar;
    }

    private ProgressBar() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }
}
