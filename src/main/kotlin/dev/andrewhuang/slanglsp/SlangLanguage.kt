package dev.andrewhuang.slanglsp

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader

object SlangLanguage : Language("Slang") {
    val icon = IconLoader.getIcon("/META-INF/pluginIcon.svg", javaClass)

    @Suppress("unused")
    private fun readResolve(): Any = SlangLanguage
}
