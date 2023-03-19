package com.mygdx.game.pathfinder;

import com.badlogic.gdx.ai.pfa.Heuristic;
import com.badlogic.gdx.math.Vector3;

public class TileHeuristic implements Heuristic<Vector3> {

    @Override
    public float estimate(Vector3 node, Vector3 endNode) {
        return 0;
    }
}
