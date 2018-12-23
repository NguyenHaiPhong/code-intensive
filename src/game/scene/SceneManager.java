package game.scene;

public class SceneManager {
    public static Scene currentSence;

    public static void signNewScene(Scene newSence) {
        if(currentSence != null) {
            currentSence.clear();
        }
        newSence.init();
        currentSence = newSence;
    }
}
