package com.fjbg.abstract

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.fjbg.GdxAppNodeConnection

class NodeConnectionApp : AndroidApplication() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val config = AndroidApplicationConfiguration()
		initialize(GdxAppNodeConnection(), config)
	}
}