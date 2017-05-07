package com.rpsparty.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import com.rpsparty.game.controller.entities.PaperHandBody;
import com.rpsparty.game.controller.entities.RockHandBody;
import com.rpsparty.game.controller.entities.ScissorHandBody;
import com.rpsparty.game.model.MatchModel;

public class MatchController implements ContactListener {
    /**
     * The singleton instance of this controller
     */
    private static MatchController instance;

    public static final int ARENA_WIDTH = 800;
    public static final int ARENA_HEIGHT = 480;

    private final World world;
    /*private final RockHandBody rock;
    private final PaperHandBody paper;
    private final ScissorHandBody scissor;*/

    private MatchController() {
        world = new World(new Vector2(0, 0), true);

        /*rock = new RockHandBody(world, MatchModel.getInstance().getRock());
        paper = new PaperHandBody(world, MatchModel.getInstance().getPaper());
        scissor = new ScissorHandBody(world, MatchModel.getInstance().getScissor());*/

        world.setContactListener(this);
    }

    /**
     * Returns a singleton instance of a game controller
     *
     * @return the singleton instance
     */
    public static MatchController getInstance() {
        if (instance == null)
            instance = new MatchController();
        return instance;
    }

    public void update(float delta) {

    }

    public World getWorld() {
        return world;
    }

    public void chooseRock() {
        //rock.setTransform(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8,0);
        MatchModel.getInstance().getRock().setPosition(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8);
        ConnectionSockets.getInstance().sendMessage("rock");
    }

    public void choosePaper() {
        //paper.setTransform(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8,0);
        MatchModel.getInstance().getPaper().setPosition(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8);
        ConnectionSockets.getInstance().sendMessage("paper");
    }

    public void chooseScissor() {
        //scissor.setTransform(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8,0);
        MatchModel.getInstance().getScissor().setPosition(Gdx.graphics.getWidth()/12, 5*Gdx.graphics.getHeight()/8);
        ConnectionSockets.getInstance().sendMessage("scissor");
    }

    /**
     * A contact between two objects was detected
     *
     * @param contact the detected contact
     */
    @Override
    public void beginContact(Contact contact) {
        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        //TODO: adicionar animacao ao choque de elementos

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }


}
