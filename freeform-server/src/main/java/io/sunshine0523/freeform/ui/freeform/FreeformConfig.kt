package io.sunshine0523.freeform.ui.freeform

data class FreeformConfig(
    var width: Int,
    var height: Int,
    var densityDpi: Int,
    var secure: Boolean = true,
    var ownContentOnly: Boolean = true,
    var shouldShowSystemDecorations: Boolean = true,
    var refreshRate: Float,
    var hangUpWidth: Int = 300,
    var hangUpHeight: Int = 400,
    var isHangUp: Boolean = false,
    // 记录挂起前的位置，以便恢复
    var notInHangUpX: Int = 0,
    var notInHangUpY: Int = 0,
    var isScaling: Boolean = false,
    //小窗屏幕宽高，与view的比例
    var freeformWidth: Int,
    var freeformHeight: Int
) {
    constructor(width: Int, height: Int, densityDpi: Int, secure: Boolean, ownContentOnly: Boolean, shouldShowSystemDecorations: Boolean, refreshRate: Float) : this(width, height, densityDpi, secure, ownContentOnly, shouldShowSystemDecorations, refreshRate, 300, 400, false, 0, 0, false, 1080, 1920) {

    }
}