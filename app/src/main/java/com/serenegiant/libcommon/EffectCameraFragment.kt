package com.serenegiant.libcommon
/*
 * libcommon
 * utility/helper classes for myself
 *
 * Copyright (c) 2014-2020 saki t_saki@serenegiant.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

import android.os.Bundle
import android.util.Log
import android.view.View
import com.serenegiant.glutils.EffectRendererHolder
import com.serenegiant.glutils.GLEffect
import com.serenegiant.widget.EffectCameraGLSurfaceView

class EffectCameraFragment : AbstractCameraFragment() {
	override fun isRecording(): Boolean {
		// FIXME 未実装
		return false
	}

	override fun internalStartRecording() {
		if (DEBUG) Log.v(TAG, "internalStartRecording:")
		// FIXME 未実装
	}

	override fun internalStopRecording() {
		if (DEBUG) Log.v(TAG, "internalStopRecording:")
		// FIXME 未実装
	}

	override fun onFrameAvailable() {
		// FIXME 未実装
	}

	override fun onLongClick(view: View): Boolean {
		if (mCameraView is EffectCameraGLSurfaceView) {
			val v = view as EffectCameraGLSurfaceView
			v.effect = (v.effect + 1) % GLEffect.EFFECT_NUM
			return true
		}
		return false
	}

	companion object {
		private const val DEBUG = true // TODO set false on release
		private val TAG = EffectCameraFragment::class.java.simpleName

		fun newInstance(): EffectCameraFragment {
			val fragment = EffectCameraFragment()
			val args = Bundle()
			args.putInt(ARGS_KEY_LAYOUT_ID, R.layout.fragment_camera_effect)
			args.putInt(ARGS_KEY_TITLE_ID, R.string.title_effect_camera)
			fragment.arguments = args
			return fragment
		}
	}
}