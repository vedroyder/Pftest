package com.mygdx.game.pathfinder;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultConnection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class TileGraph implements IndexedGraph<Vector3> {

    public ArrayList<Vector3>list;

    public TileGraph(ArrayList<Vector3>list) {
      this.list = list;
        System.out.println("inited " + list.size() + " nodes");
    }

    @Override
    public int getIndex(Vector3 node) {
        for (Vector3 v : list)
            if (v.equals(node)) {
                return list.indexOf(v);
            }
        return -1;
    }

    @Override
    public int getNodeCount() {
        return list.size();
    }

    @Override
    public Array<Connection<Vector3>> getConnections(Vector3 fromNode) {
        Array<Connection<Vector3>>tiles = new Array<>();
        System.out.println("Tile #" + getIndex(fromNode) + " : " + fromNode.toString());

        for (float i = -1; i<=1; i++)
        for (float j = -1; j<=1; j++)
        for (float k = -2; k<=2; k++)
        {
            Vector3 check = new Vector3((fromNode.x + i),(fromNode.y + k),(fromNode.z + j));
            if (getIndex(check)>-1)
                if (Math.abs(check.y - fromNode.y) <= 1) {
                    tiles.add(new DefaultConnection<>(fromNode, check));
                    System.out.println("++ #" + getIndex(check) + " " + check);
                } else System.out.println("-- #" + getIndex(check) + " " + check);

        }
        return tiles;
    }

}
