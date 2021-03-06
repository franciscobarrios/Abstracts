package com.fjbg.abstracts

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration

class NodeConnectionApp : AndroidApplication() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val config = AndroidApplicationConfiguration()
		initialize(GdxAppNodeConnection(), config)
	}
}