package es.danirod.rectball.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import es.danirod.rectball.RectballGame;
import es.danirod.rectball.actors.Value;
import es.danirod.rectball.utils.SoundPlayer;
import es.danirod.rectball.utils.SoundPlayer.SoundCode;

public class GameOverScreen extends MenuScreen {

    private Value score;

    public GameOverScreen(RectballGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();

        Label gameOver = newLabel("GAME OVER");
        table.add(gameOver).pad(40).colspan(2).expandX().expandY().align(Align.center).row();

        Texture sheet = game.manager.get("scores.png", Texture.class);
        score = new Value(sheet, 6, game.scores.getLastScore());
        table.add(score).pad(40).colspan(2).fillX().height(200).row();

        TextButton replay = newButton("Replay");
        TextButton menu = newButton("Menu");
        table.add(replay).pad(40).expandX().height(100);
        table.add(menu).pad(40).expandX().height(100).row();

        replay.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.player.playSound(SoundCode.SUCCESS);
                game.setScreen(1);
            }
        });
        menu.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.player.playSound(SoundCode.FAIL);
                game.setScreen(3);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.3f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public int getID() {
        return 2;
    }
}
