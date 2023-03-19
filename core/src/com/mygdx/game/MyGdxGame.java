package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.pathfinder.TileGraph;
import com.mygdx.game.pathfinder.TileHeuristic;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		ArrayList<Vector3>vecs = new ArrayList<>();
		for (int i = 0; i<=3; i++)
		for (int j = 0; j<=3; j++)
		for (int k = 0; k<=3; k++)
			vecs.add(new Vector3(i,j,k));
		Vector3 vstart = vecs.get(1);
		Vector3 vend = vecs.get(6);
		System.out.println("From " + vstart.toString());
		System.out.println("To " + vend.toString());
		TileGraph graph = new TileGraph(vecs);
		IndexedAStarPathFinder<Vector3> pathFinder = new IndexedAStarPathFinder<>(graph);
		DefaultGraphPath<Vector3> out = new DefaultGraphPath<>();
		pathFinder.searchNodePath(vstart,vend,new TileHeuristic(), out);
		DefaultGraphPath<Vector3> path = out;
		System.out.println(out.nodes.size);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
