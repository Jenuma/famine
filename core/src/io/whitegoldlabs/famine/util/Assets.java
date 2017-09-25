package io.whitegoldlabs.famine.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets
{
	public AssetManager assetManager = new AssetManager();
	
	// ------------------------------------------------------------------------------------------//
	// Sprites                                                                                   //
	// ------------------------------------------------------------------------------------------//
	public static final AssetDescriptor<Texture> mapTest =
			new AssetDescriptor<Texture>(Gdx.files.internal("map_test_grid.png"), Texture.class);
	
	public static final AssetDescriptor<Texture> unitTest =
			new AssetDescriptor<Texture>(Gdx.files.internal("unit_test.png"), Texture.class);
	
	// ------------------------------------------------------------------------------------------//
	// Music                                                                                     //
	// ------------------------------------------------------------------------------------------//
	
	
	// ------------------------------------------------------------------------------------------//
	// Sound Effects                                                                             //
	// ------------------------------------------------------------------------------------------//
	
	
	// load()
	// This function loads all assets at once. This will need to be rewritten if it performs
	// suboptimally.
	public void load()
	{
		assetManager.load(mapTest);
		assetManager.load(unitTest);
		assetManager.finishLoading();
	}
}
