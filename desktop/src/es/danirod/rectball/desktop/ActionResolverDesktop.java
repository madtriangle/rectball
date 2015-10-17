package es.danirod.rectball.desktop;

import com.badlogic.gdx.Gdx;

import es.danirod.rectball.ActionResolver;

public class ActionResolverDesktop implements ActionResolver {
    @Override
    public void shareGame(String msg) {
        Gdx.app.log("ShareGame", msg);
    }

    @Override
    public void shareGameWithScreenshot(String msg) {
        Gdx.app.log("ShareGameWithScreenshot", msg);
    }

    @Override
    public void toast(String string) {
        Gdx.app.log("Toast", string);
    }

    @Override
    public void rateGame() {
        Gdx.app.log("RateGame", "Clicked");
    }
}
