package cs102a.gui;

import java.io.File;

/**
 * @version 0.1, Chris, Apr 23
 */

public interface GameGuiInterface {
    /**
     * Should be placed in GameGUI's constructor, after creating and placing all swing elements.
     * <p>
     * Call the main LOGIC part that:
     * - creates a map, say, gameGui.map = new Map(<?>)
     * - add listeners to all JButtons
     * - load music, user info, etc
     *
     * @since ver 0.1
     */
    void start();

    /**
     * Start a new Game and place the state before set visible.
     *
     * @param record a txt that records the state of:
     *               - the checked buttons
     *               - the map
     *               - state of two players, like score, props
     * @since ver 0.1
     */
    void loadHistory(File record);
}
